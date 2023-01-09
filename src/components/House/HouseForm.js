import React, { useState } from "react";
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
import { Icon, InputAdornment, makeStyles, OutlinedInput } from "@mui/material";
import Button from "@mui/material/core/Button";

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
  
const handleSubmit = () => {
    saveHouse();
    SetisSent(true);
    refreshHouse();
}

function HouseForm(props){
    const {houseId, houseDurum, refreshHouse} = props;
    const clases = useStyles();
    const [expanded, setExpanded] = useState(false);
    const [text, SetText] = useState("");
    const [title, SetTitle] = useState("");
    const [isSent, SetisSent] = useState(false);

    const handleExpandClick = () => {
        setExpanded(!expanded);
    }

    const handleTitle = (value) => {
        SetTitle(value);
        SetisSent(false)
    }

    const handleText = (value) => {
        SetText(value);
        SetisSent(false);
    }

    const saveHouse = (value) => {
        fetch("/houses", {
            method : "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
            text: text,
            workplaceId: workplaceId,
            title: title
            }),
        })
    }

    const handleSubmit = () => {
        saveHouse();
        SetisSent(true);
        SetTitle();
        SetText();
        refreshHouse();
    }

    return(
        <div>
        <Card sx={{ maxWidth: 345 }}>
        <CardHeader
        avatar={
          <link className={clases.link} to={{pathnama : '/workplace/' + workplaceId}}>WorkPlace
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            {houseDurum.charAt(0).toUpperCase()}
          </Avatar>
          </link>
        }
        title={<OutlinedInput
            id = "outlined-adorment-amount"
            multline
            placerholder ="Title"
            inputProps = {{maxLenght : 25}}
            fullWidth
            value={title}
            onChange={(i) => handleTitle(i.target.value)}
            >
        </OutlinedInput>}
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
        <OutlinedInput
            id = "outlined-adorment-amount"
            multline
            placerholder ="Text"
            inputProps = {{maxLenght : 25}}
            fullWidth
            value={text}
            onChange={(i) => handleText(i.target.value)}
            endAdornment = {
                <InputAdornment position="end"
                style={{background: 'linear-gradient(45deg, #2196F3 30%, #21CBF3 90%',
                color: 'white'}}>
                <button variant = "contained"
                style={{background: 'linear-gradient(45deg, #2196F3 30%30, #21CBF 90%)',
                color : 'white'}}
                onClick = {handleSubmit}> Housee
                </button>
                </InputAdornment>
            }
            >
        </OutlinedInput>
        </Typography>
      </CardContent>
    </Card>
    </div>
    )
}

export default HouseForm;