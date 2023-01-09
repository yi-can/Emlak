import React from "react";
import House from "../House/House";
import HouseForm from "../House/HouseForm";

const usetyles = makeStyles((theme) => ({
    contanier: {
        display: "flex",
        flexWrap: "wrap",
        justifyContent: "center",
        alignItems: "center",
        backgroundcolor: '#f0f5ff'
    }
}))

function Home() {
    
    const [error, setError] = useState(null);
    const [isLoaded, setisLoaded] = useState(false);
    const [postList, setpostList] = useState([]);

    useEffect(() => {
        refreshHouse();
    }, [postList])

    if(error) {
        return <div> Error !!! </div>
    } else if(!isLoaded) {
        <div> Loading !!! </div>
    } else {
        return(
            <div className="container">
            <House></House>
        
                {postList.map(post => (
                    <House
                        title={post.EmlakTuru}
                        text={post.Durum}>
                    </House>
                ))}
            </div>
            
        );
    }
    return(
        <div fixed className = {clases.container}>
        <HouseForm houseId = {post.houseId} houseDurum = {post.houseDurum} title={post.title} text={post.text}/>
        {postList.map(post => (
            <House houseId = {post.houseId} houseDurum = {post.houseDurum} title={post.title} text={post.text}></House>
        ))}
        </div>
    )
}

export default Home;