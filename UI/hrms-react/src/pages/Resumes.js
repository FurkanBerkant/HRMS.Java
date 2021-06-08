import React, { useState, useEffect } from 'react'
import { Image, Item } from 'semantic-ui-react'
import ResumeService from '../services/resumeService.js';
import { Table } from 'semantic-ui-react'

export default function Resumes() {
    const [resumes, setResumes] = useState([]);
    useEffect(() => {
        let resumeService = new ResumeService();
        resumeService.getResumes().then(result => setResumes(result.data.data))
    }, [])
    const paragraph = <Image src='https://react.semantic-ui.com/images/wireframe/short-paragraph.png' />
    return (
        <div>
            <Table inverted celled fixed>
                <Table.Header>
                    CV'LER
                    <Table.Row>
                        <Table.HeaderCell>Name</Table.HeaderCell>
                        <Table.HeaderCell>LinkedIn</Table.HeaderCell>
                        <Table.HeaderCell>GithubLink</Table.HeaderCell>
                        <Table.HeaderCell>photoUrl</Table.HeaderCell>
                        <Table.HeaderCell>description</Table.HeaderCell>
                        <Table.HeaderCell>jobExperiences</Table.HeaderCell>
                        <Table.HeaderCell>jobExpJobTitle</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {resumes.map((resume) => (
                        <Table.Row key={resume.id}>
                            <Table.Cell>{resume.jobSeekerFirstName}</Table.Cell>
                            <Table.Cell>{resume.linkedInLink}</Table.Cell>
                            <Table.Cell>{resume.githubLink}</Table.Cell>
                            <Table.Cell>{resume.photoUrl}</Table.Cell>
                            <Table.Cell>{resume.description}</Table.Cell>
                            <Table.Cell>{resume.jobExperiences[0].companyName}</Table.Cell>
                            <Table.Cell>{resume.jobExperiences[0].jobTitle.position}</Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div>
    )
}