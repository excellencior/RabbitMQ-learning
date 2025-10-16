import { useState } from 'react';

function App() {
	const [msg, setMsg] = useState('');

	const send = async () => {
		await fetch('/api/messages', {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({ msg })
		});
		setMsg('');
	};

	return (
		<div style={{ padding: 20 }}>
			<input value={msg} onChange={e => setMsg(e.target.value)} placeholder="Message" />
			<button onClick={send}>Send</button>
		</div>
	);
}

export default App;