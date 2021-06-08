import React, { useState, useEffect } from 'react'
import JobTitleService from '../services/jobTitleService'
import { Table } from 'semantic-ui-react'
export default function JobTitles() {
    const [jobTitles, setJobTitles] = useState([]);
    useEffect(() => {
        let jobTitleService = new JobTitleService();
        jobTitleService.getJobTitles().then(result => setJobTitles(result.data.data))
    }, [])
    return (
        <div>
            <Table inverted celled fixed>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>POZİSYONLAR</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {jobTitles.map((jobTitle) => (
                        <Table.Row key={jobTitle.id}>
                            <Table.Cell>{jobTitle.position}</Table.Cell>

                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div>
    )
}
