type HeaderProps = {
    stationName: string
    slogan: string
}

function Header({stationName, slogan}: HeaderProps) {
  return (
    <header>
      <h1>{stationName}</h1>
      <p>{slogan}</p>
    </header>
  )
}

export default Header
