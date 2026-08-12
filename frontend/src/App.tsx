import Header from './components/Header'
import Footer from './components/Footer'
import RadioPlayer from './components/RadioPlayer'
import Schedule from './components/Schedule'
import './App.css'

const station = {
  name: 'En el altar de Dios',
  slogan: 'Una voz en el altar, siempre',
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
  return (
    <>
      <Header
        stationName={station.name}
        slogan={station.slogan}
      />

      <main>
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
