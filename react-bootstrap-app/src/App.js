
//import "custom-style";
import "bootstrap/dist/css/bootstrap.min.css";
import { Route, Routes } from "react-router-dom";
import LoginTest from "./Componant/LoginTest";

import Navbar from "./Componant/Navbar"; 
import ProfComponent from "./Componant/ProfComponent";
import ProfTabl from "./Componant/ProfTabl";
import AffecterProf from "./Componant/Admin/AffecterProf";
import TablOfProf from "./Componant/Admin/TablOfProf";
function App() { //mb-4 pour donne marginbutton =4
  return ( <>
  
  <Routes>
  <Route path="" element={<LoginTest />}/>
  <Route path="/prof" element={<>
    <Navbar />
    <ProfComponent />
    </>}/>
    <Route path="/profT" element={<>
    <Navbar />
    <ProfTabl />
    </>}/>
  <Route path="/Admin" element={<>
    <Navbar />
    <AffecterProf />
  
    </>}/>
    <Route path="/AdminHome" element={<>
    <Navbar />
    <AffecterProf />
  
    </>}/>
    <Route path="/AdminP" element={<>
    <Navbar />
    <TablOfProf />
  
    </>}/>
  </Routes>
 {/* <Container className="acoter">  {/*classname mettre dans elle des class et define dans dans css ou use des class pret define*/}
  {/* <Routes>
    <Route path="/" element={<Navbar />}/> {/*element pour componant appeler si acceder path     */ } 
    {/* <Route path="/Filier" element={<Navbar />}/>
    <Route path="/Profs" element={<Navbar />}/>
    <Route path="/Users" element={<Navbar />}/>
  </Routes>
  </Container>*/}

</>)

};
export default App;
