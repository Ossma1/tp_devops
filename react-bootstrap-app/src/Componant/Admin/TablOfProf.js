import React, { useEffect, useState } from 'react'
import Sidebar from '../Sidebar'
import Search from './Search'
import axios from 'axios';
import { Button } from 'react-bootstrap';
const TablOfProf = () => {
  
  const [reload, setreload] = useState('');
  var [Profs,SetProfs] =useState([])
  const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte')).compteType;
  
  useEffect (() => {
    if(ProfOrAdmn==='ADMIN'){ 
    axios.get('http://localhost:8080/professeurs', 
      
    ).then(function (response) {
      
    
      console.log(JSON.stringify(response.data));
      SetProfs(response.data);

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

,[reload])
const handleGenere = (element) => {
  axios.post('http://localhost:8080/compte/generate-prof', 
  element
  ).then(function (response) {
      console.log(element);
      setreload(reload+'1');

      console.log(reload);
      console.log(JSON.stringify(response.data));
      

    //console.log(Profs)
    })
    .catch(function (error) {
        console.log(error);
    });
  
    
  }

  
  return (

    <div>
    <div className="main">
<Sidebar />

<div className="contenu">
    <Search />

    <br></br>
    <table>
        <tr>
        <th>code</th>  
        <th>Nom</th>
        <th>Prenom</th>
        <th>Specialite</th>
        <th>compte</th>
        </tr>

        {Profs.map((item, index) => 
    
        <tr>

        <td>{item.id_prof}</td>
        <td>{item.nom}</td>
        <td>{item.prenom}</td>
        <td>{item.specialite}</td>
        <td>
          {item.compte==null ?<Button onClick={() => handleGenere(item)} style={{fontSize:'12px'}}  variant="outline-success" className="">Genere</Button> : <Button style={{fontSize:'12px'}} variant="secondary" disabled>Genere</Button> }

        
          </td>
        </tr>
        ) }
    </table>
</div>
</div>
</div>
  )
}

export default TablOfProf