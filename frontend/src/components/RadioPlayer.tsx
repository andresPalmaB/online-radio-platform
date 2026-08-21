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
            return
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
        <section className='radio-player'>
            <h2 className='radio-player__heading'>Reproducción actual</h2>
            <h3 className='radio-player__program'>{programName}</h3>
            <p className='radio-player__presenter'>Presentado por {presenter}</p>
            <p className='radio-player__status'>{isLive ? 'En vivo ahora' : 'Programa grabado'}</p>

            <audio 
            ref={audioRef} 
            src={streamUrl || undefined} 
            onPlay={() => setIsPlaying(true)}
            onPause={() => setIsPlaying(false)}
            onEnded={() => setIsPlaying(false)}
            />

            <button 
                className='radio-player__button'
                type="button"
                onClick={togglePlayback}
                disabled={!streamUrl}
            >
                {isPlaying ? 'Pausar radio' : 'Reproducir radio'}
            </button>
        </section>
    )
}

export default RadioPlayer
