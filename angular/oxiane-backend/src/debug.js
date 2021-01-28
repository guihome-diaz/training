
export function safeStringify(object) {
	var cache = []; 
	       
	var str = JSON.stringify(
		// Object to convert to JSON
		object,
		// Replacer function
		function(key, value) {
			if (typeof value === 'object' && value !== null) {
				if (cache.indexOf(value) !== -1) {
					// Circular reference found, discard key
					return;
				}
				
				// Store value in our collection
				cache.push(value);
			}
			
			return value;
		},
		// Indent using 4 spaces
		4
	);
	
	cache = null;
	
	return str;
}
