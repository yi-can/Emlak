import React from "react";
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
    const {text, workplaceId, workplaceName} =props;
    const clases = useSttles();

    return (
        <CardContent className = {ClassNames.coment}>
        <OutlinedInput>
        disabled
        id = "outlined-adorment-amount"
        multline
        inputProps = {{maxLenght : 25}}
        fullWidth
        value = {text}
        startAdorment = {
            <InputAdornment position="start">
                <Link className = {clases.link} to={{pathname : '/workplace/' + workplaceId}}>
                    <Avatar aria-label="recipe" className={clases.avatar}>
                        {UNSAFE_getPathContributingMatches.chasAt(0).toUpperCase()}
                    </Avatar>
                </Link>

            </InputAdornment>
        }
        style = {{color : "blackj",backgroundColor: 'white'}}
        </OutlinedInput>
        </CardContent>
    )
}

export default Customer;

