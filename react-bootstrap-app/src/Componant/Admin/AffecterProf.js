import React, { useEffect, useState } from 'react'
import { Button } from 'react-bootstrap'
import SemestreCards from '../SemestreCards'
import Sidebar from '../Sidebar'
import BoiteDialogue from './BoiteDialogue'
import Modal from 'react-modal';
import TablOfProf from './TablOfProf'
import swal from 'sweetalert'
import axios, { Axios } from 'axios'
const AffecterProf = () => {
  const [reload, setreload] = useState('');
  var elementAffecter ="";
  var ProfAffecter ="";
  const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte')).compteType;
  const[Profs,SetProfs]=useState([])
  const [modalite,setmodalite]=useState([])

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [name, setName] = useState('');

  const handleOpenModal = () => {
    
    setIsModalOpen(true);
  }

  const handleCloseModal = () => {
    setIsModalOpen(false);
  }

  const handleChange = (event) => {
    setName(event.target.value);
  }
  const showConfirmAlert = () => {  
    swal({
        title: "Are you sure?",
        text: "vous avez affecter l'element"+elementAffecter+"au Professeur "+ProfAffecter,
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willabscent) => {
        if (willabscent) {
            //hna finn ghat3ti varile abscent la valeur terue
          swal("Poof! element affected", {
            icon: "success",
          });setreload(reload+'1');
        } else {
          swal("c'est bon l'etudiant n'est pas Affecter!");
        }
      });
  }
  const handleSubmit = (event) => {
    
    event.preventDefault();
    var l=document.getElementsByName('prof')
    for(var i=0;i<l.length;i++){
      if(l[i].checked){
        elementAffecter=modalite[0].modele[0].element.nom
      ProfAffecter=document.getElementById(l[i].value).innerHTML
        axios.post('http://localhost:8080/element-To-prof?id_element='+modalite[0].modele[0].element.id_element+'&id_prof='+l[i].value, 
      
      ).then(function (response) {
          if(response.data==="element affected")
          {
          showConfirmAlert();
        
        }
        else{
          swal("c'est bon l'etudiant n'est pas abscent!");
        }
        
        //console.log(Profs)
        })
        .catch(function (error) {
            console.log(error);
        });
      }

    }
    setIsModalOpen(false);
  }



 const fctDlg =()=> {
  alert("ef");
  <BoiteDialogue />
 }
 useEffect (() => {
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('nom');


console.log(id);
axios.post('http://localhost:8080/note-element', 
        {"nom": id}
      )
        .then(function (response) {
          setmodalite(
            [{"modele":
            response.data}
          ]);
             
   //   window.location.href = '/'+response.data.compteType;
        })
        .catch(function (error) {
            console.log(error);
        });

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
      },[reload])
      console.log('hahiya',modalite.modele)  
  return (
    <>

    <div>
      
    <Modal
      isOpen={isModalOpen}
      onRequestClose={handleCloseModal}

      style={{
        content: {marginLeft:"12%",maxWidth: '566px',width: '75vw',maxHeight:'60vh',borderRadius: '14px',backgroundColor: 'gray'
    }}}
  >
          <form onSubmit={handleSubmit}>
            <label>
            choisir un Prof:
            <input
          type="text"
          placeholder="Search..."
          style={{
            width: '50%',
            height: '40px',
            fontSize: '16px',
            border: '1px solid #ddd',
            borderRadius: '4px',
            padding: '0 12px',
            marginLeft: '54px'
          }}
          value={name} onChange={handleChange} 
        />
              </label>
           
            
            <div style={{marginTop:'20px'}}>
    <table  >
        <tr>
          <th></th>
          <th>Nom Prof</th>
          <th>Prenom Prof</th>
          <th>Specialite</th>
        </tr>
        
      {Profs.map((item, index) => 
      <tr>
          <td><input type='radio' name="prof" value={item.id_prof} ></input></td>
          <td id={item.id_prof}>{item.nom}</td>
          <td>{item.prenom}</td>
          <td>{item.specialite}</td>
      </tr>)}
        
    </table></div><br></br>
    
    <Button style={{backgroundColor:"white",color:"black",float:'left',  marginLeft:"85%"}} type="submit">Affecter</Button>
          </form>
    </Modal>
  </div>    
    <div>


      

          <div className="main">
  <Sidebar />
  <div className="contenu">
  <table>
  {modalite.map((item, index) => 
    <tr>
     <th>Module</th>
      <th>Element</th>
      <th>Coeffetion</th>
      <th> Semestre</th>
      {item.modele.map((item,index) =>
      <th>{item.modalite.nom}</th>
      )}
      <th>Affectation</th>
      </tr>
  )}
   
    

    {modalite.map((item, index) => 
    <tr>
      <td>{item.modele[0].element.module.nom}</td>
      <td>{item.modele[0].element.nom}</td>
      <td>{item.modele[0].element.coeff}</td>
      <td>{item.modele[0].element.module.semestre}</td>
      
      {item.modele.map((item,index) =><td>
      
      {item.modalite.nom} : {item.coeff}</td>
      )}


      

      <td>
        
       {item.modele[0].element.professeur==null ? <Button onClick={handleOpenModal} style={{fontSize:'12px'}}  variant="outline-success" className="">Affecter</Button>: <Button style={{fontSize:'12px'}} variant="secondary" disabled>Deja Fait</Button>}</td>
    </tr>
)}
    </table>
  </div>
    </div>
    </div>
    </>)
}

export default AffecterProf
