import React, { useState, useEffect } from 'react'
import JobSeekerService from '../../services/jobSeekerService';
import { Table } from 'semantic-ui-react'
export default function JobSeeker() {
    const [jobSeekers, setJobSeekers] = useState([]);
    useEffect(() => {
        let jobSeekerService = new JobSeekerService();
        jobSeekerService.getJobSeekers().then(result => setJobSeekers(result.data.data))
    }, [])
    return (
        <div>
            <Table inverted celled fixed>
                <Table.Header>
                    İŞ ARAYANLAR
                    <Table.Row>
                        <Table.HeaderCell>E-mail</Table.HeaderCell>
                        <Table.HeaderCell>AD</Table.HeaderCell>
                        <Table.HeaderCell>SOYAD</Table.HeaderCell>
                        <Table.HeaderCell>TC KİMLİK</Table.HeaderCell>
                        <Table.HeaderCell>DOĞUM TARİHİ</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {jobSeekers.map((jobSeeker) => (
                        <Table.Row key={jobSeeker.id}>
                            <Table.Cell>{jobSeeker.email}</Table.Cell>
                            <Table.Cell>{jobSeeker.firstName}</Table.Cell>
                            <Table.Cell>{jobSeeker.lastName}</Table.Cell>
                            <Table.Cell>{jobSeeker.identityNumber}</Table.Cell>
                            <Table.Cell>{jobSeeker.dateOfBirth}</Table.Cell>

                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div>
    )
}
