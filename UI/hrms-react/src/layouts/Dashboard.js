import { Grid } from "semantic-ui-react";
export default function Dashboard({ children }) {

    return (
        <div>
            {children}
            <Grid>
                <Grid.Row>
                    <Grid.Column width={1}></Grid.Column>
                    <Grid.Column width={12}>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    )
}