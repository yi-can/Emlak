import React, { useRef, useState, useEffect } from "react";
import "./House.scss"
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, { IconButtonProps } from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import HomeIcon from '@mui/icons-material/Home';
import BedroomParentIcon from '@mui/icons-material/BedroomParent';
import { Icon, makeStyles } from "@mui/material";

const useStyles = makeStyles((theme => ({
    root: {
        width: 800,
        textAlign : "left",
        margin : 20
    },
    media: {
        height: 0,
        paddingTop: '56.25%', //16:9
    },
    expand:{
        transform: 'rotate(0deg)',
        marginLeft: 'auto',
        transition: theme.transition.create('transfrom', {
            duration: theme.transition.duration.shortest
        }),
    },
    avatar : {
        backgroundColor: red[500],
    },
    link: {
        TextDecoration : "none",
        boxShadow: "none",
        color : "white"
    }
})))
  

function House(props){
    const {title, text, houseId, houseDurum} = props;
    const clases = useStyles();
    const [expanded, setExpanded] = useState(false);
    const [error, setError] = useState(null);
    const [commentList, setcommentList] =useState([]);
    const isIntialMount = useRef(true);

    const handleExpandClick = () => {
        setExpanded(!expanded);
    }

    const refreshHouse = () => {
      fetch("/houses")
      .then(res => res.json())
      .then(
          (reult => res.json())
          .then(
              (result) => {
                  setisLoaded(true);
                  setpostList(result);
              },
              (error) => {
                  setisLoaded(true);
                  setpostList(error);
              }
          )
      )
  }

    useEffect(() => {
        if(isIntialMount.current)
            isIntialMount.current = false;
        else
            refreshHouse();
    }, [HouseList])

    return(
        <div className="HouseContainer">
            <Card sx={{ maxWidth: 345 }}>
      <CardHeader
        avatar={
          <link className={clases.link} to={{pathnama : '/workplace/' + workplaceId}}>WorkPlace
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            {houseDurum.charAt(0).toUpperCase()}
          </Avatar>
          </link>
        }
        title={title}
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          {text}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <Icon aria-label="Home">
          <FavoriteIcon />
        </Icon>
        <Icon aria-label="BedroomParent">
          <ShareIcon />
        </Icon>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <Container fixed className = {ClassNames.contanier}>
          {error? "error" :
          isLoaded? commentList.map(comment => (
            <Comment workplaceId = {1} workplaceName = {"WORKPLACE"} text = {comment.text}></Comment>
          )) : "Loading"}
        </Container>
      </Collapse>
    </Card>
            {title}
            {text}
        </div>
    )
}

export default House;