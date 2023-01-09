import React from "react";
import { Link } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { makeStyles } from "@mui/material";

const useStyles =makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        textAlign : "left"
    },
    menuButton: {
        marginRight: theme.spacing(2)
    },
    title: {
        flexGrow: 1,
    },
    link: {
        TextDecoration : "none",
        boxShadow: "none",
        color : "white"
    }
}));

function Navbar() {

    return(
        <div>
            <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <link className={clases.link} to="/">Home</link>
          </Typography>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <link className={clases.link} to={{pathnama : '/workplace/' + workplaceId}}>WorkPlace</link>
          </Typography>
        </Toolbar>
      </AppBar>
        </div>
    )
}



