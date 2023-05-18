import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Cardd from './Cardd'


const SemestreCards = ({item}) => {

  var Filier={}
  var sem="";
  var semestre ='';
  var list1 =[];
  var list2 =[];
  const [F, setF] = useState([]);
  var object = {};
  var object2 = {};
  
  var listF=[];



  useEffect(() => {
    setF([])
    
  axios.post('http://localhost:8080/Professeur-element', 
  JSON.parse(localStorage.getItem('compte'))
  ).then(function (response) {
    console.log(response.data)
    Filier=response.data;
    Filier.map((item, index) =>{
      semestre=item.module.semestre;
      object.semestre=item.module.semestre;
      Filier.map((item, index) =>{
        if(item.module.semestre===semestre){
          object2=item;
          list2.push(object2);
          object2={};}
        })
          object.childrens=list2;
          list2=[];
        list1.push(object)
        object={};
    })  

    setF(Array.from(new Set(list1)))

  })
  .catch(function (error) {
    console.log(error);
  });
  
  
  setF(Array.from(new Set(F)))
  console.log('fdf',F);
},[F])

  return (<>    
  
  {F.map((item, index) => 
    <div className='SemesterCards'>
                        {item.semestre} 
       <hr style={{color :"white"}}></hr>
    <div style={{display:'flex',justifyContent:'space-around'}}>
    
    { item.childrens.map((itema, index) =>  <Cardd key={index} item={itema} />) }    
       
      </div>
      <br></br>
    </div>)
}</>)
}
  
export default SemestreCards
