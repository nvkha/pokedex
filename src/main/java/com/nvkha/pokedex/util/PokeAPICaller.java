package com.nvkha.pokedex.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.nvkha.pokedex.service.AbilityService;
import com.nvkha.pokedex.service.impl.TypeServiceImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nvkha.pokedex.model.entity.Ability;
import com.nvkha.pokedex.model.entity.Pokemon;
import com.nvkha.pokedex.model.entity.Type;
import com.nvkha.pokedex.service.TypeService;

public class PokeAPICaller {
    private TypeService typeService;
    private AbilityService abilityService;

    public PokeAPICaller(TypeService typeService, AbilityService abilityService) {
        this.typeService  = typeService;
        this.abilityService = abilityService;
    }
    public List<Type> getAllType() {
        List<Type> types = new ArrayList<>();
        try {
            URL url = new URL("https://pokeapi.co/api/v2/type");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.addRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            JSONObject jsonObject = new JSONObject(content.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                types.add(new Type(jsonArray.getJSONObject(i).getString("name")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return types;
    }

    public List<Ability> getAllAbility() {
        List<Ability> abilities = new ArrayList<>();
        try {
            for(int i = 1; i <= 267; i++) {
                URL url = new URL("https://pokeapi.co/api/v2/ability/" + i);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.addRequestProperty("User-Agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                JSONObject jsonObject = new JSONObject(content.toString());
                String effect = jsonObject.getJSONArray("effect_entries").getJSONObject(1).getString("effect");
                abilities.add(new Ability(jsonObject.getLong("id"), jsonObject.getString("name"), effect));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return abilities;
    }

    public List<Pokemon> getListPokemon() {
        List<Pokemon> pokemons = new ArrayList<>();
        try {
            for(int i = 1; i <= 100; i++) {
                URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + i);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.addRequestProperty("User-Agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                JSONObject jsonObject = new JSONObject(content.toString());
                Pokemon pokemon = new Pokemon((long) i, jsonObject.getString("name"), jsonObject.getDouble("weight"), jsonObject.getDouble("height"));
                for(int j = 0; j < jsonObject.getJSONArray("types").length(); j++) {
                    pokemon.getTypes().add(typeService.getTypeByName(jsonObject.getJSONArray("types").getJSONObject(j)
                            .getJSONObject("type").getString("name")));
                }

                for(int j = 0; j < jsonObject.getJSONArray("abilities").length(); j++) {
                    pokemon.getAbilities().add(abilityService.getAbilityByName(jsonObject.getJSONArray("abilities").getJSONObject(j)
                            .getJSONObject("ability").getString("name")));
                }
                pokemons.add(pokemon);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return pokemons;
    }
}
