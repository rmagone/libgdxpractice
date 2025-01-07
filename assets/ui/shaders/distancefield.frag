#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_texCoords;

uniform sampler2D u_texture;
uniform float u_smoothing;

void main() {
    float distance = texture2D(u_texture, v_texCoords).a;
    float alpha = smoothstep(0.5 - u_smoothing, 0.5 + u_smoothing, distance);
    gl_FragColor = vec4(v_color.rgb, v_color.a * alpha);
}
