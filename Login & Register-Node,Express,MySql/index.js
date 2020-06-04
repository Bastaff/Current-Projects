
const sql = require('./db/db_conn');
const express = require('express');
const path = require('path');
const app = express();
const bodyParser = require('body-parser');
const auth = require('./routes/auth');


app.use(express.static(path.join(__dirname, 'public')));
sql.MySQLConnect(); // Connect to SQL database
app.use(bodyParser.urlencoded({extended: true}));




app.use('/', auth);





const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server started on: ${PORT}`));