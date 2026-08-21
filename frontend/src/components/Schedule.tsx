export type ScheduleEntry = {
    scheduleId: number
    programId: number
    programName: string
    presenter: string
    dayOfWeek: string
    startTime: string
}

type ScheduleProps = {
    programs: ScheduleEntry[]
}

const dayNames: Record<string, string> = {
    MONDAY: 'Lunes',
    TUESDAY: 'Martes',
    WEDNESDAY: 'Miércoles',
    THURSDAY: 'Jueves',
    FRIDAY: 'Viernes',
    SATURDAY: 'Sábado',
    SUNDAY: 'Domingo',
}

function formatDay(dayOfWeek: string) {
    return dayNames[dayOfWeek] ?? dayOfWeek
}

function formatTime(startTime: string) {
    const [hours, minutes] = startTime.split(':').map(Number)
    const time = new Date(1970, 0, 1, hours, minutes)

    return new Intl.DateTimeFormat('es-CO', {
        hour: 'numeric',
        minute: '2-digit',
        hour12: true,
    }).format(time)
}

function Schedule({ programs }: ScheduleProps) {
    return (
        <section className="schedule">
            <h2 className="schedule__heading">Programación semanal</h2>

            <ul className="schedule__list">
                {programs.map((program) => (
                    <li className="schedule__item" key={program.scheduleId}>
                        <h3>{program.programName}</h3>
                        <p>Presentado por {program.presenter}</p>
                        <p>{formatDay(program.dayOfWeek)}</p>
                        <time dateTime={program.startTime}>{formatTime(program.startTime)}</time>
                    </li>
                ))}
            </ul>
        </section>
    )
}

export default Schedule
