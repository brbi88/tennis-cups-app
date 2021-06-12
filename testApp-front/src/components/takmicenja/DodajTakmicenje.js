import React from "react";
import {Button, Form} from "react-bootstrap";
import TestAppAxios from "../../apis/TestAppAxios";

class DodajTakmicenje extends React.Component {

    constructor(props) {
        super(props);

        let takmicenje = {
           naziv: "",
           mestoOdrz: "",
           datPocetka: "",
           datZavrsetka: "",
           formatId: -1,
        
        };
        this.state = {
            takmicenje: takmicenje,
            takmicenja: [],
            formati: []
        };
    }

    componentDidMount() {
        this.getTakmicenja();
        this.getFormati();
    }

    async getTakmicenja() {
        try {
            let takmicenje = this.state.takmicenje;
            let takmicenjeDTO = {
                naziv: takmicenje.naziv,
                mestoOdrz: takmicenje.mestoOdrz,
                datPocetka: takmicenje.datPocetka,
                datZavrsetka: takmicenje.datZavrsetka,
                formatId: takmicenje.formatId
            }
            let result = await TestAppAxios.get("/takmicenja", takmicenjeDTO);
            if(result && result.status === 200) {
                this.setState({
                    takmicenja: result.data,
                });
            }
        }catch (error) {
            alert("Nije uspelo dobavljanje.");
        }
    }

    async getFormati() {
        try {
            let result = await TestAppAxios.get("/formati");
            if (result && result.status === 200) {
                this.setState({
                    formati: result.data,
                });
            }
        }catch (error) {
            console.log(error);
            alert("Nije uspelo dobavljanje.")
        }  
    }

    async create() {
        try {
            await TestAppAxios.post("/takmicenja/", this.state.takmicenje);

            let takmicenje = {
                naziv: "",
                mestoOdrz: "",
                datPocetka: "",
                datZavrsetka: "",
                formatId: -1,
            };
            this.setState({takmicenje: takmicenje});

            this.getTakmicenja(0);
            this.props.history.push("/takmicenja");
        }catch(error) {
            alert("Nije uspelo dodavanje.")
        }
    }

    addValueInputChanged(e) {
        let control = e.target;

        let name = control.name;
        let value = control.value;

        let takmicenje = this.state.takmicenje;
        takmicenje[name] = value;

        this.setState({takmicenje: takmicenje});
    }

    render() {
        return (
            <div>
                <h1>Dodaj takmicenje</h1>
                <Form>
                    <Form.Group>
                        <Form.Label>Naziv takmicenja</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChanged(event)}
                            name="naziv"
                            value={this.state.takmicenje.naziv}
                            as="input">
                            </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Mesto odrzavanja</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChanged(event)}
                            name="mestoOdrz"
                            value={this.state.takmicenje.mestoOdrz}
                            as="input">
                            </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Datum pocetka takmicenja</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChanged(event)}
                            name="datPocetka"
                            value={this.state.takmicenje.datPocetka}
                            as="input">
                            </Form.Control>
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Datum zavrsetka takmicenja</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChanged(event)}
                            name="datZavrsetka"
                            value={this.state.takmicenje.datZavrsetka}
                            as="input">
                            </Form.Control>
                    </Form.Group>
                    <Form.Group>
                    <Form.Label>Format</Form.Label>
                        <Form.Control
                        onChange={(event) => this.addValueInputChanged(event)}
                        name="formatId"
                        value={this.state.takmicenje.formatId}
                        as="select">
                            <option value={-1}></option>
                            {this.state.formati.map((format) => {
                                return (
                                    <option value={format.id} key={format.id}>
                                        {format.tipTakmicenja}
                                    </option>
                                );
                            })}
                        </Form.Control>
                    </Form.Group>
                
                    <Button onClick={() => this.create()}>
                        Kreiraj takmicenje
                    </Button>
                </Form><br/>
                </div>
        );
    
    }

}
    export default DodajTakmicenje;