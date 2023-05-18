
import React, { useState } from 'react';
const Search = () => {
    const [searchTerm, setSearchTerm] = useState('');
    return (
    <div>
      <form>
    <input
      type="text"
      placeholder="Search..."
      style={{
        width: '20%',
        height: '40px',
        fontSize: '16px',
        border: '1px solid #ddd',
        borderRadius: '4px',
        padding: '0 12px',
        marginLeft: '75%'
       }}
      value={searchTerm}
      onChange={event => setSearchTerm(event.target.value)}
    />
  {/*   <button type="submit">Rechercher</button>
  */}
  
  </form> 
    </div>
  )
}

export default Search
