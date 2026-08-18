import Header from './components/Header'
import Footer from './components/Footer'
import RadioPlayer from './components/RadioPlayer'
import Schedule from './components/Schedule'
import { useEffect, useState } from 'react'
import './App.css'

interface Station {
  name: string
  slogan: string
}

const currentProgram = {
  programName: 'Ezequiel 7:23',
  presenter: 'Antonio Bustos',
  isLive: true,
  streamUrl: '',
}

const weeklyPrograms = [
  {
    id: 1,
    name: 'Oración de la Mañana',
    presenter: 'Antonio Bustos',
    time: '8:00 AM',
  },
  {
    id: 2,
    name: 'Ezequiel 7:23',
    presenter: 'Antonio Bustos',
    time: '2:00 PM',
  },
  {
    id: 3,
    name: 'Reflexión de la noche',
    presenter: 'Radio Team',
    time: '7:00 PM',
  },
]

function App() {
  const [station, setStation] = useState<Station | null>(null)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    const loadStation = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/station')
        if (!response.ok) {
          throw new Error(`Request failed with status ${response.status}`)
        }

        const data: Station = await response.json()

        setStation(data)
      } catch {
        setError('Unable to load station information.')
      }
    }

    loadStation()
  }, [])

  if (error !== null) {
    return <p>{error}</p>
  }

  if (station === null) {
    return <p>Loading station information...</p>
  }

  return (
    <>
      <Header
        stationName={station.name}
        slogan={station.slogan}
      />

      <main className='main-content'>
        <RadioPlayer
          programName={currentProgram.programName}
          presenter={currentProgram.presenter}
          isLive={currentProgram.isLive}
          streamUrl={currentProgram.streamUrl}
        />

        <Schedule programs={weeklyPrograms} />
      </main>

      <Footer />
    </>
  )
}

export default App
