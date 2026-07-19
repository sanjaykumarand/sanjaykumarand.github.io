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

  // On mobile, touch-dragging on the canvas is disabled (pointer-events:
  // none in CSS) so the page can scroll normally. Instead, simulate mouse
  // movement as the user scrolls, so color still splats while scrolling.
  var isMobile = window.matchMedia('(max-width: 768px)').matches;

  if (isMobile) {
    var lastScrollY = window.scrollY;
    var scrollX = canvas.width / 2;

    window.addEventListener('scroll', function () {
      var currentScrollY = window.scrollY;
      var delta = currentScrollY - lastScrollY;
      lastScrollY = currentScrollY;

      // Drift the x position side to side a bit so splats aren't a
      // straight vertical line, and wrap the y position within the
      // canvas height using the scroll delta.
      scrollX += delta * 0.5;
      if (scrollX < 0) scrollX = canvas.width;
      if (scrollX > canvas.width) scrollX = 0;

      var y = (currentScrollY * 2) % canvas.height;

      canvas.dispatchEvent(new MouseEvent('mousemove', {
        clientX: scrollX,
        clientY: y,
        bubbles: true
      }));
    }, { passive: true });
  }
});