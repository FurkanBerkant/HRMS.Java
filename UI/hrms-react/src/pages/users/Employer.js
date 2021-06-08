import React, { useEffect, useState } from 'react'
import EmployerService from '../../services/employerService';
import { Table } from 'semantic-ui-react'
export default function Employer() {
    const [employers, setEmployers] = useState([])
    useEffect(() => {
        let employerService = new EmployerService();
        employerService.getEmployer().then(result => setEmployers(result.data.data));
    }, [])

    return (
        <div>
            <Table inverted celled fixed>
                <Table.Header>
                    İŞ VERENLER
                    <Table.Row>
                        <Table.HeaderCell>E-mail</Table.HeaderCell>
                        <Table.HeaderCell>ŞİRKET ADI</Table.HeaderCell>
                        <Table.HeaderCell>WEB SİTE </Table.HeaderCell>
                        <Table.HeaderCell>TELEFON</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {employers.map((employer) => (
                        <Table.Row key={employer.id}>
                            <Table.Cell>{employer.email}</Table.Cell>
                            <Table.Cell>{employer.companyName}</Table.Cell>
                            <Table.Cell>{employer.webSiteName}</Table.Cell>
                            <Table.Cell>{employer.phone}</Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div >
    )
}
