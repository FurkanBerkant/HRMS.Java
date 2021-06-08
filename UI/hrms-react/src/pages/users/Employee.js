import React, { useEffect, useState } from 'react'
import EmployerService from '../../services/employeeService';
import { Table } from 'semantic-ui-react'
export default function Employee() {
    const [employees, setEmployees] = useState([])
    useEffect(() => {
        let employeeService = new EmployerService();
        employeeService.getEmployee().then(result => setEmployees(result.data.data));
    }, [])

    return (
        <div>
            <Table inverted celled fixed>
                <Table.Header>
                    SİSTEM ÇALIŞANLARI
                    <Table.Row>
                        <Table.HeaderCell>E-mail</Table.HeaderCell>
                        <Table.HeaderCell>ADI</Table.HeaderCell>
                        <Table.HeaderCell>SOYADI</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    {employees.map((employee) => (
                        <Table.Row key={employee.id}>
                            <Table.Cell>{employee.email}</Table.Cell>
                            <Table.Cell>{employee.firstName}</Table.Cell>
                            <Table.Cell>{employee.lastName}</Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div >
    )
}
