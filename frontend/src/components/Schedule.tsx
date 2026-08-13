type Program = {
    id: number
    name: string
    presenter: string
    time: string
}

type ScheduleProps = {
    programs: Program[]
}

function Schedule({ programs }: ScheduleProps) {
    return (
        <section className="schedule">
            <h2 className="schedule__heading">Weekly schedule</h2>

            <ul className="schedule__list">
                {programs.map((program) => (
                    <li className="schedule_item" key={program.id}>
                        <h3>{program.name}</h3>
                        <p>Presented by {program.presenter}</p>
                        <time>{program.time}</time>
                    </li>
                ))}
            </ul>
        </section>
    )
}

export default Schedule