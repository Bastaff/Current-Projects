
const io = require('socket.io');



module.exports = (io, socket) => {
  socket.on('chat message', (msg) => {
    io.emit('chat message', msg);
  });
};


