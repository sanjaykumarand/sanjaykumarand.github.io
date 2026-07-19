document.addEventListener('DOMContentLoaded', function () {
  var canvas = document.getElementById('fluid');

  function resizeCanvas() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
  }
  resizeCanvas();
  window.addEventListener('resize', resizeCanvas);

  WebGLFluid(canvas, {
    TRIGGER: 'hover',
    IMMEDIATE: false,
    AUTO: false,
    INTENSITY: 4,
    SIM_RESOLUTION: 128,
    DYE_RESOLUTION: 1024,
    DENSITY_DISSIPATION: 1.8,
    VELOCITY_DISSIPATION: 1.2,
    PRESSURE: 0.8,
    CURL: 25,
    SPLAT_RADIUS: 0.35,
    SPLAT_FORCE: 4000,
    SHADING: true,
    COLORFUL: true,
    COLOR_UPDATE_SPEED: 8,
    BACK_COLOR: { r: 0.02, g: 0.02, b: 0.03 },
    TRANSPARENT: false,
    BLOOM: true,
    BLOOM_INTENSITY: 0.9,
    BLOOM_THRESHOLD: 0.4,
    SUNRAYS: true,
    SUNRAYS_WEIGHT: 0.6
  });
});