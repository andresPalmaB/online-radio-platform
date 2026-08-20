import Header from './components/Header'
import Footer from './components/Footer'
import RadioPlayer from './components/RadioPlayer'
import Schedule, { type ScheduleEntry } from './components/Schedule'
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

function App() {
  const [station, setStation] = useState<Station | null>(null)
  const [stationError, setStationError] = useState<string | null>(null)
  const [schedule, setSchedule] = useState<ScheduleEntry[] | null>(null)
  const [scheduleError, setScheduleError] = useState<string | null>(null)

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
        setStationError('Unable to load station information.')
      }
    }

    loadStation()
  }, [])

  useEffect(() => {
    const loadSchedule = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/schedule')
        if (!response.ok) {
          throw new Error(`Request failed with status ${response.status}`)
        }

        const data: ScheduleEntry[] = await response.json()

        setSchedule(data)
      } catch {
        setScheduleError('Unable to load schedule information.')
      }
    }

    loadSchedule()
  }, [])

  if (stationError !== null) {
    return <p>{stationError}</p>
  }

  if (station === null) {
    return <p>Loading station information...</p>
  }

  if (scheduleError !== null) {
    return <p>{scheduleError}</p>
  }

  if (schedule === null) {
    return <p>Loading schedule information...</p>
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

        <Schedule programs={schedule} />
      </main>

      <Footer />
    </>
  )
}

export default App
