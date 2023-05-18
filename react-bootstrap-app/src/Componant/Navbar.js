import React, { useEffect, useState } from "react";
import { Button, Container, Nav, Navbar as NavbarBs } from "react-bootstrap";
import { NavLink } from "react-router-dom";
import { Avatar } from 'evergreen-ui' 
import axios from "axios";
//import { useShoppingCart } from "../context/ShoppingCartContext";
const Navbar = () => {
  //const { openCart, cartQuantity } = useShoppingCart();
  const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte'));
  const [prof,setprof]=useState([])
  useEffect (() => {
  axios.post('http://localhost:8080/Espace-professeur', 
  ProfOrAdmn
)
  .then(function (response) {
    setprof(response.data);
    
  })
  .catch(function (error) {
      console.log(error);
  });
  },[]);
  console.log(prof.nom+' '+prof.prenom)
  return (
    <NavbarBs  sticky="top" className="bg-white shadow-sm " style={{position:"fixed",width:"100%"}}> {/*sticky:pour mettre bar in the top and fux */}
      <Container>
        <Nav className="me-auto">
        

          <Nav.Link to="/" as={NavLink}>                        {/*navelink :ya3ni rahna khdamn biha comme navllink dyal react */}
            Markes App
          </Nav.Link>
          
        </Nav>
       {ProfOrAdmn.compteType==="ADMIN" ? <Avatar name="Admin" size={50} /> :  <Avatar name={prof.nom+' '+prof.prenom} size={50} />        } 
          
          <Button
            style={{marginLeft: 30, width: "6rem", height: "3rem", position: "relative" }}
            variant="outline-primary"
          >
          <Nav.Link onClick={()=> localStorage.clear() } to="/" as={NavLink}>
            Logout
          </Nav.Link>
          </Button>
      </Container>
    </NavbarBs>
  );
};

export default Navbar;
