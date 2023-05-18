import React from 'react'
import { Route, Routes } from "react-router-dom";
import Citems from "../data/Semester.json"
import SemestreCards from "./SemestreCards";
import Sidebar from "./Sidebar"; 
import Navbar from './Navbar';
import TableauProf from './TableauProf';


const ProfComponent = () => {
  return (
    <div>
      <div className="main">
  <Sidebar />
  <div className="contenu" id='contenu'>
    <SemestreCards  />
 {/*   if(){
      }
      else{
  <TableauProf />
      }
  {/* faut mettre if else not the routs   
 {Citems.map((item, index) => <SemestreCards key={index} item={item} />)}*/}
 
  </div>
    </div>
    </div>
  )
}

export default ProfComponent
