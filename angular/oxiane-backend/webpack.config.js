const packageJson = require('./package.json');
const artifactName = packageJson.name;

module.exports = {
	mode: 'none',
	target: 'node',
	context: __dirname + '/src',
	entry: './main.js',
	output: {
		path: __dirname + '/build',
		filename: artifactName+ '.js',
	},
	module: {
		rules: [
			{
				test: /\.(js)$/,
				loader: 'babel-loader',
				exclude: /node_modules/,
			},
		]
	},
	stats: {
		warningsFilter: /^(?!CriticalDependenciesWarning$)/,
	},
}
