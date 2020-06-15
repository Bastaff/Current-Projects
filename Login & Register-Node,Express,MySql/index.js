const express = require('express');
const app = express();
const sql = require('./db/db_conn');
const path = require('path');
const bodyParser = require('body-parser');
const auth = require('./routes/auth');

// Prerequisites
app.use(express.static(path.join(__dirname, 'public')));
sql.MySQLConnect(); // Connect to SQL database
app.use(bodyParser.urlencoded({extended: true}));

// Routes
app.use('/', auth);


const PORT = process.env.PORT || 5000;
const server = app.listen(PORT, () => console.log(`Server started on: ${PORT}`));

// Sockets
const io = require('socket.io').listen(server);

 
io.on('connect', (socket) => {
    require("./public/viewsJS/socket")(io, socket);
  });