type HeaderProps = {
    stationName: string
    slogan: string
}

function Header({ stationName, slogan }: HeaderProps) {
  return (
    <header className="site-header">
      <div className="site-header__content">
        <h1 className="site-header__title">{stationName}</h1>
        <p className="site-header__slogan">{slogan}</p>
      </div>
    </header>
  )
}

export default Header
