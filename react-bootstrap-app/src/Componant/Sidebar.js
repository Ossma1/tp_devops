import SidebarItem from "./SidebarItem"
import items from "../data/sidebarProf.json"
import itemsA from "../data/sidebar.json"
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import { useEffect, useState } from "react";

export default function Sidebar(){
  
  const location = useLocation();
  const url = location.pathname;
  const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte')).compteType;
  var Filier={}
  var fili ='';
  var modl ='';
  var list =[];
  var list1 =[];
  var list2 =[];
  const [F, setF] = useState([]);
  var object = {};
  var object2 = {};
  var object3 = {};
  var listF=[];

//

//

useEffect(() => {
  //console.log(ProfOrAdmn)
  if(ProfOrAdmn==='ADMIN'){ 
  axios.get('http://localhost:8080/elements', 
    
  ).then(function (response) {

    Filier=response.data;
//

Filier.map((item, index) =>{
fili=item.module.filiere.nom;
object.title=item.module.filiere.nom;
Filier.map((item, index) =>{
  if(item.module.filiere.nom===fili){
    modl=item.module.nom;
    object2.title=item.module.nom;
      
          Filier.map((item, index) =>{
            if(item.module.nom===modl){
              object3.title=item.nom;
              list2.push(object3);
              object3={};
            }
          })
          object2.childrens=list2;
          object3={}
          list2=[]
    list.push(object2);
    object2={};
  }
})
var listM=Array.from(new Set(list))
object.childrens=listM;
list1.push(object)
object2={}
list=[]
})
listF=Array.from(new Set(list1))
setF(listF)
//test lst est json
//listF.map((item, index) =>{
  //item.childrens.map((item, index) =>{
//  console.log(item,item.childrens) })
//})

//console.log(listF[0].childrens[1]);
//Filier.map((item, index) => items.add(item.module.filiere.nom)  )

  //console.log(items);
  //console.log(Filier);
// console.log(JSON.parse(localStorage.getItem('compte')));
    })
    .catch(function (error) {
        console.log(error);
    });
  }
  
  else if(ProfOrAdmn==='PROFFESSEUR'){
    axios.post('http://localhost:8080/Professeur-element', 
    JSON.parse(localStorage.getItem('compte'))
    ).then(function (response) {
      console.log(response.data)
      Filier=response.data;
      Filier.map((item, index) =>{
        object.title=item.module.filiere.nom;
        list1.push(object)
      })
      listF=Array.from(new Set(list1))
      setF(listF)
   {/*   setFilier(response.data);  
    console.log(response.data);*/}
  //      console.log(JSON.parse(localStorage.getItem('compte')));
      })
      .catch(function (error) {
          console.log(error);
      });
  }
 } ,[])
//
console.log(F)
  return (  <div className="sidebar">
          {url==="/Prof" || url==="/ProfT" ?(
        <div>
        { items.map((item, index) => <SidebarItem filier={F} key={index} item={item} />) }
        </div>
      )  : url==="/ADMINP" || url==="/ADMIN"? (
        <div>
          
        { itemsA.map((item, index) => <SidebarItem filier={F} key={index} item={item} />) }
        </div>
      ) : (
        null
      )}

          </div>
          
    )
}
