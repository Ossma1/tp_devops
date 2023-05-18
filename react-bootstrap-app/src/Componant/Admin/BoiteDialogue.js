import React, { useState } from 'react';//usestate gerer l'état local d'un composant.
import Modal from 'react-modal';

function BoiteDialogue() {
  
  
  const [isModalOpen, setIsModalOpen] = useState(false);//si true va afffiche laboite Dialogue
  const [name, setName] = useState('');
const  handleOpenModal=()=>
{

  setIsModalOpen(true);
}
  
 
  const handleCloseModal = () => {
    setIsModalOpen(false);
  }

  const handleChange = (event) => {//use cette fonction pour des besoins pour inseert la valeur de input dans state
    setName(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    //hna ydar traitement 3la apres choix du prof
    window.alert(`Merci, ${name}!`);
    setIsModalOpen(false);
  }

  return (
    <div>
      
      <Modal
        isOpen={isModalOpen}
        onRequestClose={handleCloseModal}
        style={{
            content: {
                maxWidth: '566px',
                margin:'auto',
                width: '75vw',
                maxHeight:'60vh',
                borderRadius: '14px',
                backgroundColor: '#fff'
        }}}
      >
         <button onClick={handleOpenModal}>Ouvrir la boîte de dialogue</button>
     
        <form onSubmit={handleSubmit}>
          <label>
            Nom :
            <input type="text" value={name} onChange={handleChange} />
          </label>
          <button type="submit">Envoyer</button>
          <button onClick={handleCloseModal}>Annuler</button>
        </form>
      </Modal>
    </div>
  );
}

export default BoiteDialogue;
