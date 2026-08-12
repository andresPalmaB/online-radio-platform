import { useRef, useState } from 'react'

type RadioPlayerProps = {
    programName: string
    presenter: string
    isLive: boolean
    streamUrl: string
}

function RadioPlayer({
    programName,
    presenter,
    isLive,
    streamUrl
}: RadioPlayerProps) {
    const [isPlaying, setIsPlaying] = useState(false)
    const audioRef = useRef<HTMLAudioElement>(null)

    async function togglePlayback() {
        const audio = audioRef.current

        if (!audio) return

        if (!streamUrl){
            console.error('No radio stream URL is configured.')
        }

        if (!audio.paused) {
            audio.pause()
            return
        }

        try {
            await audio.play()
        } catch (error) {

            if (error instanceof DOMException && error.name === 'AbortError'){
                return
            }

            console.error('Unable to play the radio stream:', error)
            setIsPlaying(false)
        }
    }

    return (
        <section>
            <h2>Now Playing</h2>
            <h3>{programName}</h3>
            <p>Presented by {presenter}</p>
            <p>{isLive ? 'Live now' : 'Recorded program'}</p>

            <audio 
            ref={audioRef} 
            src={streamUrl || undefined} 
            onPlay={() => setIsPlaying(true)}
            onPause={() => setIsPlaying(false)}
            onEnded={() => setIsPlaying(false)}
            />

            <button 
                type="button"
                onClick={togglePlayback}
                disabled={!streamUrl}
            >
                {isPlaying ? 'Pause radio' : 'Play radio'}
            </button>
        </section>
    )
}

export default RadioPlayer