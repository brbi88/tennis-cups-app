import React from "react";
import {Table, Button, Form, ButtonGroup} from "react-bootstrap";
import TestAppAxios from "../../apis/TestAppAxios";


class Takmicenje extends React.Component {

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
            formati: [],
            search: {formatId: -1, mestoOdrz: ""},
            pageNo: 0,
            totalPages: 1,
        };
    }

    componentDidMount() {
        this.getData();
    }

    async getData() {
        await this.getFormati();
        await this.getTakmicenja(0);
    }

    async getTakmicenja(page) {
        let config = {
            params: {
                pageNo: page
            }
        };

    
        if(this.state.search.formatId != -1) {
            config.params.formatId = this.state.search.formatId;
        }
        if(this.state.search.mestoOdrz != "") {
            config.params.mestoOdrz = this.state.search.mestoOdrz;
        }

        try {
            let result = await TestAppAxios.get("/takmicenja", config);
            if(result && result.status === 200) {
                this.setState({
                    pageNo: page,
                    takmicenja: result.data,
                    totalPages: result.headers["total-pages"],
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

    async doDelete(takmicenjeId) {
        try {
            await TestAppAxios.delete("/takmicenja/" + takmicenjeId);
            this.getTakmicenja(0);
        }catch (error) {
            alert("Nije uspelo brisanje.");
        }
    }

     searchValueInputChanged(event) {
         let control = event.target;

         let name = control.name;
         let value = control.value;

         let search = this.state.search;
         search[name] = value;

         this.setState({search: search});
     }


    doSearch() {
        this.getTakmicenja(0);
    }

    goToPrijave(takmicenjeId) {
        this.props.history.push("/takmicenja/prijava/" + takmicenjeId);
    }

    render() {
        return (
            <div>
                <h1>Takmicenja</h1>
                <Form style={{marginTop:35}}>
                <Form.Group>
                        <Form.Label>Format</Form.Label>
                        <Form.Control
                        onChange={(event) => this.searchValueInputChanged(event)}
                        onClick={() => this.doSearch()}
                        name="formatId"
                        value={this.state.search.formatId}
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
                    <Form.Group>
                        <Form.Label>Mesto održavanja</Form.Label>
                        <Form.Control
                        value={this.state.search.mestoOdrz}
                        name="mestoOdrz"
                        as="input"
                        onChange={(e) => this.searchValueInputChanged(e)}
                        onKeyUp={() => this.doSearch()}>
                        </Form.Control>
                    </Form.Group>
                </Form>

                <ButtonGroup style={{marginTop: 25}}>
                     <Button 
                     disabled={this.state.pageNo==0} onClick={()=>this.getTakmicenja(this.state.pageNo-1)}>
                    Prethodna
                    </Button>
                    <Button 
                     disabled={this.state.pageNo==this.state.totalPages-1} onClick={()=>this.getTakmicenja(this.state.pageNo+1)}>
                    Sledeca
                    </Button>
                 </ButtonGroup>

                 <Table boardered striped style={{marginTop: 5}}>
                     <thead className="thead-dark">
                         <tr>
                             <th>Naziv takmicenja</th>
                             <th>Mesto odrzavanja</th>
                             <th>Datum pocetka takmicenja</th>
                             <th>Datum zavrsetka takmicenja</th>
                             <th>Format</th>
                         </tr>
                     </thead>
                     <tbody>
                         {this.state.takmicenja.map((takmicenje) => {
                             return (
                                 <tr key={takmicenje.id}>
                                     <td>{takmicenje.naziv}</td>
                                     <td>{takmicenje.mestoOdrz}</td>
                                     <td>{takmicenje.datPocetka}</td>
                                     <td>{takmicenje.datZavrsetka}</td>
                                     <td>{takmicenje.formatTip}</td>
                                     <td>
                                         <Button
                                         disabled={takmicenje.formatId === 3}
                                         variant="info"
                                         onClick={() => this.goToPrijave(takmicenje.id)}>
                                             Prijavi se
                                         </Button>
                                        
                                        <Button
                                        variant="danger"
                                        onClick={() => this.doDelete(takmicenje.id)}
                                        style={{marginLeft:5}}>
                                            Obriši
                                        </Button>
                                     </td>
                                 </tr>
                             )
                         })}
                     </tbody>
                 </Table>
            </div>
        );
    
    }

}

export default Takmicenje;