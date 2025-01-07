package io.github.practivce.helper;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import java.util.List;

public class MyPacker {
    public static void main(String[] args) {
//        List<String> suits = List.of("Spades", "Hearts", "Diamonds", "Clubs");
//        TexturePacker.Settings settings = new TexturePacker.Settings();
//        float widthScaleFactor = 2f / 904f;
//        float heightScaleFactor = 3f / 1281f;
//        float scaleFactor = Math.min(widthScaleFactor, heightScaleFactor);
//        settings.scale = new float[]{scaleFactor};
//        System.out.println("Scale Factor: " + scaleFactor);
//        settings.paddingX = 0;
//        settings.paddingY = 0;
            TexturePacker.process("C:\\Users\\RudolfsMagone\\Documents\\ManiProjekti\\LibgdxPractice\\assets\\ui\\comicsan\\",
                "C:\\Users\\RudolfsMagone\\Documents\\ManiProjekti\\LibgdxPractice\\assets\\", "ui\\comicsan");
    }
}
