module.exports = {
  default: {
    paths: ['src/features/**/*.feature'],
    require: [
      'ts-node/register',
      'src/steps/*.ts',
      'src/support/hooks.ts',
      'src/support/world.ts'
    ],
    format: [
      'progress',
      'json:reports/report.json'
    ],
    publishQuiet: true,
  }
};
