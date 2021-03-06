package cnpm.recipe.service;

import java.util.List;

import cnpm.recipe.model.Recipe;
import cnpm.recipe.repository.RecipeRepository;

public class RecipeService {
	
	private RecipeRepository repository;
	
	public RecipeService() {
		repository=new RecipeRepository();
	}
	
	public List<Recipe> getRecipes(){
		return repository.getRecipes();
	}
	public List<Recipe> getRecipeByIdUser(int id){
		return repository.getRecipeByIdUser(id);
	}
	public List<Recipe> getBSTRecipeByIdUser(int id){
		return repository.getBSTRecipeByIdUser(id);
	}
	public boolean insertRecipe(Recipe recipe) {
		return repository.insertRecipe(recipe) == 1? true:false;
	}
	
	public Recipe getRecipeById(int id) {
		return repository.getRecipeById(id);
	}
	
	public boolean deleteRecipeById(int id) {
		return repository.deleteRecipeById(id) == 1? true:false;
	}
	public boolean updateLuotThich(int idrecipe) {
		return repository.updateLuotThich(idrecipe) ==1?true:false;
	}
	public boolean SaveToAlbum(int idrecipe, int iduser) {
		return repository.SaveToAlbum(idrecipe, iduser) ==1?true:false;
	}
	public List<Recipe> getRecipeByName(String name){
		return repository.getRecipeByName(name);
	}
	
	public List<Recipe> getRecipeByTopic(int topic){
		return repository.getRecipeByTopic(topic);
	}
	public List<Recipe> getRecipeByTopic_Category(int topic, int category){
		return repository.getRecipeByTopic_Category(topic,category);
	}
}
