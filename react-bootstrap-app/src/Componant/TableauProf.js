import React, { useEffect, useState } from 'react'
import "./TablPrf.css";
import swal from 'sweetalert'
import { Button } from 'react-bootstrap';
import Swal from 'sweetalert2';
import axios from 'axios';

const TableauProf = () => {
  const [data, setData] = useState([]);
  const [data1, setData1] = useState([]);
  
  const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte')).compteType;
  var regex = /[?&]([^=#]+)=([^&#]*)/g,
    url = window.location.href,
    params = {},
    match;
while(match = regex.exec(url)) {
    params[match[1]] = match[2];
}
  const [Etudiant,setEtudiant]=useState([]); 
  useEffect (() => {
    console.log("frff", params.nom)
    if(ProfOrAdmn==='PROFFESSEUR'){ 
    axios.post('http://localhost:8080/note-element', 
    {
      "nom":params.nom
  }
    ).then(function (response) {
      
    
      console.log(JSON.stringify(response.data));
      setEtudiant(response.data);

    //console.log(Profs)
    })
    .catch(function (error) {
        console.log(error);
    });
    axios.post('http://localhost:8080/note-etd', 
    {
      "nom":params.nom
  }
    ).then(function (response) {
      
    
      console.log(JSON.stringify(response.data[0].mod[0].nom));
      setData(response.data);
      setData1(response.data[0].mod);


    //console.log(Profs)
    })
    .catch(function (error) {
        console.log(error);
    });



  }
  else{
    window.location.href = '/';
  }
}

,[])

    const v ="Abs";
    const v1 ="Prs";
function showTable() {
    const tableHtml = `
      <table>
        <tr>
          <th>TP</th>
          <th>CC</th>
          <th>Projet</th>
        </tr>
        <tr>
          <td>`+v+`</td>
          <td>`+v1+`</td>
          <td>`+v+`</td>
        </tr>
        
      </table>
    `;
  
    Swal.fire({
      title: 'Tableau des utilisateurs',
      html: tableHtml,
    });
  }
    const showConfirmAlert = () => {
        
        swal({
            title: "Are you sure?",
            text: "vous avez  donne une note null !",
            icon: "warning",
            buttons: true,
            dangerMode: true,
          })
          .then((willabscent) => {
            if (willabscent) {
                //hna finn ghat3ti varile abscent la valeur terue
              swal("Poof! ce étudiant est vraiment abscent!", {
                icon: "success",
              });
            } else {
              swal("c'est bon l'etudiant n'est pas abscent!");
            }
          });
      }
    const handleChange = (event) => {
        
        if(event.target.value==0 && event.target.value!=''){
           
           showConfirmAlert();
        }
    
    }
    
  return (
    <>
  
  <table>
    <tr>
      <th>Module</th>
      <th>Element</th>
      <th>Coeffetion</th>
      <th>Etudiant Name</th>
      {data1.map((item,index) => (
 <th>{item.nom}</th>
         ))}
      <th>Absent</th>
    </tr>

{data.map((item,index) => (
    
    <tr>
      <td>{item.el.module.nom}</td>
      <td>{item.el.nom}</td>
      <td>{item.el.coeff}</td>
      <td>{item.e.nom} {item.e.prenom}</td>
      {item.el.nom==="oraclea" }
      {item.notes.map((item,index) =>
        <td><input class='NOTE' type='number'  placeholder={item}
      onChange={event => handleChange(event)}
     /> </td>
       )}
     
      
      <td><Button style={{fontSize:'12px'}} onClick={()=>showTable()} variant="outline-success" className="">Affiche Abs</Button></td>
    </tr>
    ))}

    {/*Etudiant.map((item,index) => (
      <tr>
      <td>{params.module}</td>
      <td>{params.nom}</td>
      <td>{item.element.coeff}</td>
      <td>{item.etudiant.nom} {item.etudiant.prenom}</td>
      <td>12</td>
      <td>10</td>
      <td>5</td>
      
      <td>8</td>
      
      <td><Button style={{fontSize:'12px'}}  variant="outline-success" className="">Affiche Abs</Button></td>
    </tr>
    ))*/}
     
     
    
   
   
    
  </table>
  <br></br>
  <div style={{display:'flex',width:'25%',position:'relative',left:'70%',justifyContent:'space-around' }}>
<button type="button" class="btn btn-outline-success">Valider</button>
<button type="button" class="btn btn-outline-info">Save</button>
  <button type="button" class="btn btn-outline-warning">réinitialiser</button>
</div>
  </>
  )
}

export default TableauProf
