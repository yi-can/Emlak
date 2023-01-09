import React, { useState } from "react";
import { Avatar, InputAdornment, makeStyles, OutlinedInput } from "@mui/material";
import { Link } from "react-router-dom";

const useSttles = makeStyles((theme) => ({
    comment : {
        display : "flex",
        flexWrap: "wrap",
        justifyContent : "flex-start",
        alignItems : "center",
    },
    small: {
        width: theme.spacing(4),
        height: theme.spacing(4),
    },
    link: {
        textDecoration : "none",
        bozShadow: "none",
        color: "white"
    }
        
    }));

function Customer(props) {
    const {workplaceId, workplaceName, houseId} =props;
    const clases = useSttles();
    const [text, settext] =useState("");

    const saveHouse = (value) => {
        fetch("/customer", {
            method : "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
            workplaceId: workplaceId,
            workplaceName: workplaceName
            }),
        })
    }

    const handleSubmit = () => {
        saveCustomer();
        setText("");
    }

    const handleChange = (value) => {
        settext(value);
    }

    return (
        <CardContent className = {ClassNames.coment}>
        <OutlinedInput>
        id = "outlined-adorment-amount"
        multline
        inputProps = {{maxLenght : 25}}
        fullWidth
        onChange ={(i) => handleChange(i.target.value)}
        startAdorment = {
            <InputAdornment position="start">
                <Link className = {clases.link} to={{pathname : '/workplace/' + workplaceId}}>
                    <Avatar aria-label="recipe" className={clases.avatar}>
                        {UNSAFE_getPathContributingMatches.chasAt(0).toUpperCase()}
                    </Avatar>
                </Link>

            </InputAdornment>
        }
        value = {text}
        style = {{color : "blackj",backgroundColor: 'white'}}
        </OutlinedInput>
        </CardContent>
    )
}

export default CustomerForm;

