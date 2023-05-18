import { useState ,useEffect} from "react"

export default function SidebarItem(props){
    const [open, setOpen] = useState(false)
    const ProfOrAdmn  =JSON.parse(localStorage.getItem('compte')).compteType;
  
    useEffect(() => {
    //console.log(props.filier)
    },[])
    if(props.item.childrens){
        return (
            <div className={open ? "sidebar-item open" : "sidebar-item"}>
                <div className="sidebar-title">
                    <span>

                        { props.item.icon && <i className={props.item.icon}></i> }
                        {props.item.title}    
                    </span> 
                    <i className="bi-chevron-down toggle-btn" onClick={() => setOpen(!open)}></i>
                </div>
                <div className="sidebar-content">
                {props.item.title==="Filiers/Element" || props.item.title==="Filiers" ? props.filier.map((child, index) => <SidebarItem key={index} item={child} />) : props.item.childrens.map((child, index) => <SidebarItem key={index} item={child} />)}
    
                   
                </div>
            </div>
        )
    }else{
        {console.log(props.item)}
        return (
            <>       
             { ProfOrAdmn==="ADMIN"  && props.item.title==="All_profs" && 
        <a href={"http://localhost:3000/ADMINP"} className="sidebar-item plain">
        { props.item.icon && <i className={props.item.icon}></i> }
        {props.item.title}
    </a> 
    }
        { ProfOrAdmn==="ADMIN"  && props.item.title!=="All_profs" && 
    <a href={"http://localhost:3000/ADMIN?nom="+props.item.title} className="sidebar-item plain">
    { props.item.icon && <i className={props.item.icon}></i> }
    {props.item.title}
</a> }
    { ProfOrAdmn!=="ADMIN" &&
   <a href={"http://localhost:3000/Prof?nom="+props.item.title} className="sidebar-item plain">
   { props.item.icon && <i className={props.item.icon}></i> }
   {props.item.title}
</a> } 
            

        </>
)
    }
}