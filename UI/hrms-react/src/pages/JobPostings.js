import React, { useEffect, useState } from 'react';
import { Table } from 'semantic-ui-react'
import JobPostingService from '../services/jobPostingService';
export default function JobPostings() {
    const [jobPostings, setJobPostings] = useState([]);
    useEffect(() => {
        let jobPostingService = new JobPostingService();
        jobPostingService.getJobPosting().then(result => setJobPostings(result.data.data))
    }, [])
    return (
        <div>
            <Table inverted celled fixed>

                <Table.Header>
                    İŞ İLANLARI
                    <Table.Row>
                        <Table.HeaderCell>cityName</Table.HeaderCell>
                        <Table.HeaderCell>pozisyon</Table.HeaderCell>
                        <Table.HeaderCell>companyName</Table.HeaderCell>
                        <Table.HeaderCell>açıklama</Table.HeaderCell>
                        <Table.HeaderCell>son başvuru tarihi</Table.HeaderCell>
                        <Table.HeaderCell>açık pozisyon </Table.HeaderCell>
                        <Table.HeaderCell>minimum ücret</Table.HeaderCell>
                        <Table.HeaderCell>maximum ücret</Table.HeaderCell>
                        <Table.HeaderCell>aktiflik</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {jobPostings.map((jobPosting) => (
                        <Table.Row key={jobPosting.id}>
                            <Table.Cell>{jobPosting.cityName}</Table.Cell>
                            <Table.Cell>{jobPosting.jobTitlePosition}</Table.Cell>
                            <Table.Cell>{jobPosting.employerCompanyName}</Table.Cell>
                            <Table.Cell>{jobPosting.jobDescription}</Table.Cell>
                            <Table.Cell>{jobPosting.applicationDeadLine}</Table.Cell>
                            <Table.Cell>{jobPosting.minimumSalary}</Table.Cell>
                            <Table.Cell>{jobPosting.maximumSalary}</Table.Cell>
                            <Table.Cell>{jobPosting.active}</Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div>
    )
}
