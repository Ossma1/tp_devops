import axios from 'axios';
import { getMaxFilesMessage } from 'evergreen-ui';
import React, { useState } from 'react';
import swal from 'sweetalert';

import "./Login.css";
const LoginTest = () => {
  
  const [error, setError] = useState('');
  var [state,setState] =useState({ 
          email: '',
          password: ''
        })
 
  const handleChange=(event)=>{ 
      setState({
        ...state,
        [event.target.name]: event.target.value
       
      })
      }
      
    function handleSubmit(event) {
      event.preventDefault();
    
      axios.post('http://localhost:8080/Login', 
        state
      )
        .then(function (response) {

          
          window.localStorage.setItem('compte', JSON.stringify(response.data));
          console.log(JSON.parse(localStorage.getItem('compte')));
          if(response.data.compteType==="ADMIN"){
            window.location.href = '/'+response.data.compteType+'P';
          }
          else if (response.data.compteType ==="PROFFESSEUR"){
            window.location.href = '/'+'Prof';  
          }
          else if (response.data ==="Password ou email erronée"){
            alert('Password ou email erronée')
          }
        })
        .catch(function (error) {
            console.log(error);
            swal({
              title: "",
              text: "Password ou email erronée!",
              icon: "warning",
              dangerMode: true,
            })
             
            
        });
    }
    


  return (
    <span>
    <center><h2>Connexion</h2></center>
    <form id="login-form" onSubmit={handleSubmit}>
      <label for="email">Adresse email :</label><br></br>
      <input type="email" onChange={handleChange} id="email" name="email"/><br></br>
      <label for="password">Mot de passe :</label><br></br>
      <input type="password" onChange={handleChange} id="password" name="password"/><br></br><br></br>
      <button type="submit">Se connecter</button>
    </form>
  </span>
  )

}
export default LoginTest