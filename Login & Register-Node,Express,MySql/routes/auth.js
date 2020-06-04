const sql = require('../db/db_conn');
const path = require('path');
const router = require('express').Router();
const session = require('express-session');



router.use(session({
    secret: 'secret',
    resave: true,
    saveUninitialized: true,
    maxAge: 24 * 60 * 60 * 1000
}));


router.get('/', (req, res) =>{
    res.sendFile(path.join(__dirname, '../public/views/login.html'));
});

router.get('/register', (req, res) =>{
    res.sendFile(path.join(__dirname, '../public/views/register.html'));
});

router.post('/register', (req, res) => {
    console.log('Got Body = ', req.body);

    let qry = "INSERT INTO user (firstName, lastName, userName, email, password) VALUES (?,?,?,?,?)";
    let values = [  
       req.body.firstName,
       req.body.lastName,
       req.body.userName,
       req.body.email,
       req.body.password
    ];
    sql.db.query(qry, values, (err) => {
        if (err) throw err;
       // console.log("Num logs " + result.affectedRows);
    });
    res.redirect('/home');
    res.end();
});


router.post('/login', function(req, res) {

    let querry = 'SELECT * FROM user WHERE userName = ? AND password = ?';
    let username = req.body.userName;
    let password = req.body.password;

	if (username && password) {
        console.log(username, password)
		sql.db.query(querry, [username, password], function(error, results, fields) {
			if (results.length > 0) {   
				req.session.loggedin = true;
				req.session.username = username;
				res.redirect('/home');
			} else {
                res.redirect('/login');
			}			
			res.end();
		});
	} else {
		res.send('Please enter Username and Password!');
		res.end();
	}
});


router.get('/home', (req, res) =>{

    if(!req.session.loggedin){
        res.sendFile(path.join(__dirname, '../public/views/error.html'))
    } else {
        res.sendFile(path.join(__dirname, '../public/views/home.html'))
    }
})


module.exports = router;