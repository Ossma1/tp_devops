import React, { useState } from 'react'
import "./card.css";
const Cardd = ({item}) => {
var a;
 if(item.nom==="oracle"){
  a=true;
 }

  var state ={card:'white',tags:'yellow',tagsContnue:'reste'};
  if (a){
    state={card:'gray',tags:'green',tagsContnue:'active'}
  }
  return (
    <div class="card"  style={{ backgroundColor:state.card ,width: "15rem"}}>
        
  {/* <i class="bi bi-pencil"></i> <img class="card-img-top" src="..." alt="Card image cap" />*/}
  <div class="card-body">
  <h5 className='module card-title'>{item.module.nom}</h5>
  <span className='etat' style={{ backgroundColor:state.tags}}>{state.tagsContnue}</span>
  <br></br><hr style={{position:'relative',bottom:'10px'}}></hr>
    <h4 class="element card-title">{item.nom}</h4>
    <br></br>
    <p class="date card-text">
    Dernier modification:"12/05/202 21:00"
    </p>
    <span style={{display:'flex',justifyContent:'space-around'}}>
    <a href={"http://localhost:3000/ProfT?nom="+item.nom+"&module="+item.module.nom} class="btn btn-outline-primary" color='white'>{a ? <span>Acceder</span> :<span> Modifier</span>}</a>
    { a && <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" color="green" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
  <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
</svg>}
    </span>
  </div>
</div>
  )
}

export default Cardd
