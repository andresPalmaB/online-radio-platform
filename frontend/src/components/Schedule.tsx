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

function Schedule({ programs }: ScheduleProps) {
    return (
        <section className="schedule">
            <h2 className="schedule__heading">Weekly schedule</h2>

            <ul className="schedule__list">
                {programs.map((program) => (
                    <li className="schedule__item" key={program.scheduleId}>
                        <h3>{program.programName}</h3>
                        <p>Presented by {program.presenter}</p>
                        <p>{program.dayOfWeek}</p>
                        <time>{program.startTime}</time>
                    </li>
                ))}
            </ul>
        </section>
    )
}

export default Schedule
