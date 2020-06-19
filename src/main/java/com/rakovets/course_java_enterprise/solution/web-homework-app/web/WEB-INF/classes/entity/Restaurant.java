package entity;

import java.util.List;

public class Restaurant {
		private int id;
		private String name;
		private List listDish;
		private List listReview;

		public Restaurant(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}


		public List getListDish() {
			return listDish;
		}

		public void setListDish(List listDish) {
			this.listDish = listDish;
		}

		public List getListReview() {
			return listReview;
		}

		public void setListReview(List listReview) {
			this.listReview = listReview;
		}

		@Override
		public String toString() {
			return String.format("Restaurant id=%-3d, name='%s'\nDishes: %s\nReviews: %s",
					id, name, getListDish(), getListReview());
		}
}