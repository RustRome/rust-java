#![allow(dead_code)]

use std::f32::INFINITY;
use std::sync::Arc;
use std::thread;

struct Store {
    name: String,
    items: Vec<Item>,
}

#[derive(Debug)]
struct Item {
    name: &'static str,
    price: f32,
}

impl Store {
    fn new(name: String) -> Store {
        Store {
            name: name,
            items: vec![],
        }
    }

    fn add_item(&mut self, item: Item) {
        self.items.push(item);
    }

   
}

fn build_stores() -> Vec<Store> {
    let mut stores = vec![];

    let mut store = Store::new(format!("JavaStore"));
    store.add_item(Item { name: "latte", price: 5.0 });
    store.add_item(Item { name: "cioccolato", price: 1.0 });
    store.add_item(Item { name: "pane", price: 0.1 });
    stores.push(store);

    let mut store = Store::new(format!("JavaStore"));
    store.add_item(Item { name: "latte", price: 4.0});
    store.add_item(Item { name: "cioccolato", price: 1.0 });
    store.add_item(Item { name: "pane", price: 0.2 });
    stores.push(store);

    stores
}

fn main() {
    let stores = build_stores();

    let shopping_list = vec!["latte", "cioccolato"];
    
}

